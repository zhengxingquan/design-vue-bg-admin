package com.quan.core.common.http.send;

import com.baomidou.mybatisplus.extension.api.R;
import com.quan.core.common.exception.HttpException;
import com.quan.core.common.exception.other.ContinueLoop;
import com.quan.core.common.exception.other.ExitLoop;
import com.quan.core.common.exception.other.LoopException;
import com.quan.core.common.http.Request;
import com.quan.core.common.http.Response;
import com.quan.core.common.stream.Streams;
import com.quan.core.common.util.Each;
import com.quan.core.common.util.Langs;

import java.io.*;
import java.util.Map;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class FilePostSender extends PostSender {

    public static final String SEPARATOR = "\r\n";

    public FilePostSender(Request request) {
        super(request);
    }

    public static FilePostSender create(Request request) {
        return new FilePostSender(request);
    }

    @Override
    public Response send() throws HttpException {
        try {
            String boundary = "------FormBoundary" + R.UU32();
            openConnection();
            setupRequestHeader();
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            setupDoInputOutputFlag();
            Map<String, Object> params = request.getParams();
            if (null != params && params.size() > 0) {
                export(params, getOutputStream(), boundary, request.getEnc());
            }

            return createResponse(getResponseHeader());

        } catch (IOException e) {
            throw new HttpException(request.getUrl().toString(), e);
        }
    }

    public static void export(Map<String, Object> params, OutputStream out, final String boundary, final String enc) throws IOException {
        final DataOutputStream outs = new DataOutputStream(out);
        for (Map.Entry<String, ?> entry : params.entrySet()) {
            final String key = entry.getKey();
            Object val = entry.getValue();
            if (val == null)
                val = "";
            Langs.each(val, new Each<Object>() {
                @Override
                public void invoke(int index, Object ele, int length) throws ExitLoop,
                        ContinueLoop, LoopException {

                    try {
                        outs.writeBytes("--" + boundary + SEPARATOR);
                        if (ele != null && ele instanceof File) {
                            writeFile((File)ele, key, outs, boundary, enc);
                            return;
                        }
                        outs.writeBytes("Content-Disposition: form-data; name=\""
                                + key
                                + "\""
                                + SEPARATOR
                                + SEPARATOR);
                        outs.write(String.valueOf(ele).getBytes(enc));
                        outs.writeBytes(SEPARATOR);
                    }
                    catch (Exception e) {
                        throw Langs.wrapThrow(e);
                    }
                }
            });
        }
        outs.writeBytes("--" + boundary + "--" + SEPARATOR);
        Streams.safeFlush(outs);
        Streams.safeClose(outs);
    }

    protected static void writeFile(File f, String key, DataOutputStream outs, String boundary, final String enc) throws IOException {
        outs.writeBytes("Content-Disposition: form-data; name=\""
                + key
                + "\";    filename=\"");
        outs.write(f.getName().getBytes(enc));
        outs.writeBytes("\"" + SEPARATOR);
        String ct = "application/octet-stream";
        if (f.getName().endsWith(".jpg")) {
            ct = "image/jpeg";
        }
        outs.writeBytes("Content-Type: " + ct + SEPARATOR + SEPARATOR);
        InputStream is = null;
        try {
            is = Streams.fileIn(f);
            Streams.write(outs, is);
            outs.writeBytes(SEPARATOR);
        }
        finally {
            Streams.safeClose(is);
        }
    }

    @Override
    public int getEstimationSize() throws IOException {
        final int[] count = new int[1];
        for (Map.Entry<String, ?> entry : request.getParams().entrySet()) {
            count[0] += 60;
            final String key = entry.getKey();
            Object val = entry.getValue();
            if (val == null)
                val = "";
            Lang.each(val, new Each<Object>() {
                public void invoke(int index, Object ele, int length){
                    if (ele instanceof File)
                        count[0]+= ((File)ele).length() + 100;
                    else
                        try {
                            count[0] += (key+ele).getBytes(request.getEnc()).length + 100;
                        }
                        catch (UnsupportedEncodingException e) {
                        }
                }
            });
        }
        return count[0];
    }
}