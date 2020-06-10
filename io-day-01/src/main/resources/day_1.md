# IO

## day_01

### File
#### 1. File的两个常量  

```java
    public static String getProperty(String key) {
        checkKey(key);
        SecurityManager sm = getSecurityManager();
        if (sm != null) {
            sm.checkPropertyAccess(key);
        }
        return props.getProperty(key);
    }
```
此处是获取当前系统环境属性的方法，File类有两个重要参数，**pathSeparator** 和 **separator**需要从这个方法获取，该常量会拿到当前系统分隔符。

```java
class WinNTFileSystem extends FileSystem {

    private final char slash;
    private final char altSlash;
    private final char semicolon;

    public WinNTFileSystem() {
        slash = AccessController.doPrivileged(
            new GetPropertyAction("file.separator")).charAt(0);
        semicolon = AccessController.doPrivileged(
            new GetPropertyAction("path.separator")).charAt(0);
        altSlash = (this.slash == '\\') ? '/' : '\\';
    }
······
·······
······
}
```

```java
            System.out.println(File.pathSeparator);
            System.out.println(File.separator);
```
输出结果为：  
;  
\

#### 2.File类常用方法
 
