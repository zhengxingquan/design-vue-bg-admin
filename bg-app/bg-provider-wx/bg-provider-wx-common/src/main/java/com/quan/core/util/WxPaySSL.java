package com.quan.core.util;

import com.quan.core.common.stream.Streams;
import com.quan.core.common.util.Files;

import javax.net.ssl.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class WxPaySSL {

    public static SSLSocketFactory buildSSL(Object f, String password) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        byte[] buf = null;
        if (f instanceof File) {
            buf = Files.readBytes(((File) f).getAbsolutePath());
        }
        else if (f instanceof byte[]) {
            buf = (byte[])f;
        }
        else if (f instanceof InputStream) {
            buf = Streams.readBytes((InputStream)f);
        }
        else {
            throw new IllegalArgumentException("buildSSL need file or byte[] or InputStream");
        }

        keyStore.load(new ByteArrayInputStream(buf), password.toCharArray());

        TrustManagerFactory tmfactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmfactory.init(keyStore);
        TrustManager[] tms = {new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate,
                                           String paramString) throws CertificateException {
            }
            @Override
            public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate,
                                           String paramString) throws CertificateException {
            }
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }};

        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, password.toCharArray());
        SSLContext sc = SSLContext.getInstance("TLSv1");
        sc.init(kmf.getKeyManagers(), tms, new SecureRandom());
        return sc.getSocketFactory();
    }
}
