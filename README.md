# FirstLineCode

《第一行代码》学习

- Android Studio 1.5
- Android SDK Tools 24.4.1

## 坑

### HttpClient

`HttpClient`  [在 Android 6.0 已被废弃](http://developer.android.com/about/versions/marshmallow/android-6.0-changes.html)，引入方式见 <http://stackoverflow.com/questions/32153318/httpclient-wont-import-in-android-studio>

### Notification

`setLatestEventInfo` [在 Android 6.0 已被废弃](https://developer.android.com/sdk/api_diff/23/changes/android.app.Notification.html)，使用 `Notification.Builder` 替代。

Android 5.0 以后用 `Notification.Builder` 的 `setTicker` 设置的文字不会在状态栏上显示，但可以被用在可达性服务（Accessibility Service）上。

### 注意 Android 6.0 运行时权限的处理

### 第 11 章

#### LocationTest

- `locationManager.getLastKnownLocation()` 返回 `Null`：`getLastKnownLocation()` 是根据上次已知的位置获取数据，因此要先在 Google Map 里定位一次。
- 室内测试时没 GPS 信号，在 if 判断里调整下顺序，让网络定位优先，权限也要加上。
- Android 6.0 里对地理位置权限的获取采用了新的机制。
- 用 Geocoding API 获取位置信息时报错 `org.apache.http.conn.HttpHostConnectException: Connection to http://maps.googleapis.com refused`：开 ss 不管用，用 VPN 连就好了。