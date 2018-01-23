package zhuazhu.voice.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

import java.io.IOException;

/**
 * 创建时间: 2017/12/26 16:47<br/>
 * 创建人: 李涛<br/>
 * 修改人: 李涛<br/>
 * 修改时间: 2017/12/26 16:47<br/>
 * 描述: 文件处理
 */
public class FileUtils {


    /**
     * Assets获取资源
     *
     * @param context
     * @param filename
     * @return
     * @throws IOException
     */
    public static AssetFileDescriptor getAssetFileDescription(Context context, String filename) throws IOException {
        AssetManager manager = context.getApplicationContext().getAssets();
        return manager.openFd(filename);
    }
}
