package com.avoscloud.beijing.push.demo.keepalive;

import java.util.HashMap;

import android.app.Application;
import com.avos.avoscloud.AVInstallation;
import com.avos.avoscloud.AVOSCloud;

/**
 * Created by nsun on 4/28/14.
 */
public class HTBApplication extends Application {

  private static HashMap<String, String> userNameCache = new HashMap<String, String>();
  @Override
  public void onCreate() {
    super.onCreate();

    // 必需：初始化你的appid和appkey，保存installationid
    AVOSCloud.initialize(this, "2mw1d92dmi46d1rluolgj96zn8wk7fe98g0v2z0laksj2ifp",
        "i5gxt9tgr80vbavd790hhlfmmphpl7052iiirg379p14rwsu");
    AVOSCloud.showInternalDebugLog();
    AVInstallation.getCurrentInstallation().saveInBackground();

  }

  public static String lookupname(String peerId) {
    return userNameCache.get(peerId);
  }

  public static void registerLocalNameCache(String peerId, String name) {
    userNameCache.put(peerId, name);
  }

}
