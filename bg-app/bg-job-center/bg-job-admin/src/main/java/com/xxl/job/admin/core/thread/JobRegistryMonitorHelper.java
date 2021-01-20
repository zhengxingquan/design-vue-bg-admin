package com.xxl.job.admin.core.thread;

import com.xxl.job.admin.core.model.XxlJobGroup;
import com.xxl.job.admin.core.model.XxlJobRegistry;
import com.xxl.job.admin.core.schedule.XxlJobDynamicScheduler;
import com.xxl.job.core.enums.RegistryConfig;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * job registry instance
 * @author xuxueli 2016-10-02 19:10:24
 */
public class JobRegistryMonitorHelper {
	private static Logger logger = LoggerFactory.getLogger(JobRegistryMonitorHelper.class);

	private static JobRegistryMonitorHelper instance = new JobRegistryMonitorHelper();
	public static JobRegistryMonitorHelper getInstance(){
		return instance;
	}

	private Thread registryThread;
	private volatile boolean toStop = false;
	public void start(){
		//����һ���߳�
		registryThread = new Thread(new Runnable() {
			@Override
			public void run() {
				// ��toStop Ϊfalseʱ�����ѭ����
				while (!toStop) {
					try {
						// auto registry group
						// ��ȡ����Ϊ�Զ�ע���ִ������ַ�б�
						List<XxlJobGroup> groupList = XxlJobDynamicScheduler.xxlJobGroupDao.findByAddressType(0);
						if (CollectionUtils.isNotEmpty(groupList)) {

							// remove dead address (admin/executor)
							// ɾ�� 90��֮��û�и�����Ϣ��ע������� 90��û��������Ϣ���أ���������Ѿ��������⣬���Ƴ�--
							XxlJobDynamicScheduler.xxlJobRegistryDao.removeDead(RegistryConfig.DEAD_TIMEOUT);

							// fresh online address (admin/executor)
							HashMap<String, List<String>> appAddressMap = new HashMap<String, List<String>>();
							// ��ѯ��90��֮���й����µĻ����б�
							List<XxlJobRegistry> list = XxlJobDynamicScheduler.xxlJobRegistryDao.findAll(RegistryConfig.DEAD_TIMEOUT);
							//ѭ��ע������б�  ����ִ������ͬ������Щ�����б������ó���
							if (list != null) {
								for (XxlJobRegistry item: list) {
									// �жϸû���ע����ϢRegistryGroup ��RegistType �Ƿ���EXECUTOR , EXECUTOR ����û�����ע�ᵽִ���������
									// RegistType  ��Ϊ���֣� ADMIN ��EXECUTOR
									if (RegistryConfig.RegistType.EXECUTOR.name().equals(item.getRegistryGroup())) {
										// ��ȡע���ִ���� KEY  ��Ҳ����ִ������
										String appName = item.getRegistryKey();
										List<String> registryList = appAddressMap.get(appName);
										if (registryList == null) {
											registryList = new ArrayList<String>();
										}

										if (!registryList.contains(item.getRegistryValue())) {
											registryList.add(item.getRegistryValue());
										}
										// �ռ� ������Ϣ������ִ����������
										appAddressMap.put(appName, registryList);
									}
								}
							}

							// fresh group address
							//  ����ִ�����б�
							for (XxlJobGroup group: groupList) {
								// ͨ��ִ������APP_NAME  �ó�������ļ�Ⱥ������ַ
								List<String> registryList = appAddressMap.get(group.getAppName());
								String addressListStr = null;
								if (CollectionUtils.isNotEmpty(registryList)) {
									Collections.sort(registryList);
									// תΪΪString����ͨ�����ŷָ�
									addressListStr = StringUtils.join(registryList, ",");
								}
								group.setAddressList(addressListStr);
								// �� ���ִ������ ��Ⱥ������ַ�б�д�뵽���ݿ�
								XxlJobDynamicScheduler.xxlJobGroupDao.update(group);
							}
						}
					} catch (Exception e) {
						logger.error("job registry instance error:{}", e);
					}
					try {
						TimeUnit.SECONDS.sleep(RegistryConfig.BEAT_TIMEOUT);
					} catch (InterruptedException e) {
						logger.error("job registry instance error:{}", e);
					}
				}
			}
		});
		registryThread.setDaemon(true);
		//�����߳�
		registryThread.start();
	}

	public void toStop(){
		toStop = true;
		// interrupt and wait
		registryThread.interrupt();
		try {
			registryThread.join();
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
		}
	}

}
