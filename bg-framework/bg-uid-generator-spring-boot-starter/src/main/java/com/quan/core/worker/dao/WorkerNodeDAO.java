package com.quan.core.worker.dao;

import com.quan.core.worker.entity.WorkerNodeEntity;
import org.apache.ibatis.annotations.*;

/**
 * Copyright(c)2017Baidu,Inc.All Rights Reserve.
 * <p>
 * Licensed under the Apache License,Version2.0(the"License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,software
 * distributed under the License is distributed on an"AS IS"BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * <p>
 * package com.quan.baidu.uid.worker.dao;
 * <p>
 * <p>
 * DAO for M_WORKER_NODE
 *
 * @param host
 * @param port
 * @param workerNodeEntity
 * @author yutianbao
 * <p>
 * Get{@link WorkerNodeEntity}by node host
 * @return Add{@link WorkerNodeEntity}
 */

@Mapper
public interface WorkerNodeDAO {


    /***
     *
     * @author zxq(956607644 @ qq.com)
     * @date 2020/12/25 10:41
     * @param host
     * @param port
     */
    @Select("SELECT " +
            " ID," +
            " HOST_NAME," +
            " PORT," +
            " TYPE," +
            " LAUNCH_DATE," +
            " MODIFIED," +
            " CREATED" +
            " FROM" +
            " WORKER_NODE" +
            " WHERE" +
            " HOST_NAME = #{host,jdbcType=VARCHAR} AND PORT = #{port,jdbcType=VARCHAR}")
    WorkerNodeEntity getWorkerNodeByHostPort(@Param("host") String host, @Param("port") String port);

    /**
     * Add
     * <p>
     * {
     *
     * @param workerNodeEntity
     * @link WorkerNodeEntity
     * }
     */


    @Insert("INSERT INTO WORKER_NODE" +
            "(HOST_NAME," +
            "PORT," +
            "TYPE," +
            "LAUNCH_DATE," +
            "MODIFIED," +
            "CREATED)" +
            "VALUES (" +
            "#{hostName}," +
            "#{port}," +
            "#{type}," +
            "#{launchDate}," +
            "NOW()," +
            "NOW())")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void addWorkerNode(WorkerNodeEntity workerNodeEntity);


}
