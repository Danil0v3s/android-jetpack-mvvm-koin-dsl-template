# Solves warning: library class android.util.Xml depends on program class org.xmlpull.v1.XmlPullParser
-dontwarn org.xmlpull.v1.**
-keep class org.xmlpull.v1.** { *; }

# Solves task: transformClassesAndResourcesWithProguardForappRelease
# Error message: Exception while processing task java.io.IOException: java.lang.ArrayIndexOutOfBoundsException: 2
-keepnames class com.google.android.gms.** {*;}

# Preverification Options
# Preverification is irrelevant for the dex compiler and the Dalvik VM, so we can switch it off with the -dontpreverify option.
-android
-dontpreverify

# Coroutines
# ServiceLoader support
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
-keepnames class kotlinx.coroutines.android.AndroidExceptionPreHandler {}
-keepnames class kotlinx.coroutines.android.AndroidDispatcherFactory {}
-dontwarn kotlinx.coroutines.flow.**

# Most of volatile fields are updated with AFU and should not be mangled
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}

# OkHttp and OkIO
# JSR 305 annotations are for embedding nullability information.
-dontwarn javax.annotation.**

# A resource is loaded with a relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

# Animal Sniffer compileOnly dependency to ensure APIs are compatible with older versions of Java.
-dontwarn org.codehaus.mojo.animal_sniffer.*

# Koin
#-dontusemixedcaseclassnames
#-dontskipnonpubliclibraryclasses

# app
-keep class com.app.** { *; }

# Prints all rules in a file
#-printconfiguration /tmp/full-r8-config.txt
