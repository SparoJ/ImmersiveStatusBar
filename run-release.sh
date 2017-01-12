# author: fengjun
# email: fengjun.dev@gmail.com
# date: 2016-09-25

echo "\n\n >>>>> Any problem about this script refer to fengjun"

echo "\n\n >>>>> Connected device:"
adb devices

echo "\n\n >>>>> Running release build tasks... "

./gradlew --daemon --parallel --info

if [ $? -eq 0 ];then
    echo "\n\n >>>>> Build apk success... "
    echo "\n\n >>>>> Installing apk on your phone..."
    echo "\n\n >>>>> apk file: ./app/build/outputs/apk/app-release.apk"
    adb install -r ./app/build/outputs/apk/app-release.apk
    echo "\n\n >>>>> Launching apk on your phone..."
    adb shell am start -n "com.pingan.apple.immersivestatusbar/com.pingan.apple.immersivestatusbar.MainActivity" -a android.intent.action.MAIN -c android.intent.category.LAUNCHER
else
    echo "\n\n >>>>> Build apk failed, please check the error info above"
fi