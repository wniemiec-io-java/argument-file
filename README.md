![](https://github.com/wniemiec-io-java/argument-file/blob/master/docs/img/logo/logo.jpg)

<h1 align='center'>Argument File</h1>
<p align='center'>Argument file generator.</p>
<p align="center">
	<a href="https://github.com/wniemiec-io-java/argument-file/actions/workflows/windows.yml"><img src="https://github.com/wniemiec-io-java/argument-file/actions/workflows/windows.yml/badge.svg" alt=""></a>
	<a href="https://github.com/wniemiec-io-java/argument-file/actions/workflows/macos.yml"><img src="https://github.com/wniemiec-io-java/argument-file/actions/workflows/macos.yml/badge.svg" alt=""></a>
	<a href="https://github.com/wniemiec-io-java/argument-file/actions/workflows/ubuntu.yml"><img src="https://github.com/wniemiec-io-java/argument-file/actions/workflows/ubuntu.yml/badge.svg" alt=""></a>
	<a href="https://codecov.io/gh/wniemiec-io-java/argument-file"><img src="https://codecov.io/gh/wniemiec-io-java/argument-file/branch/master/graph/badge.svg?token=R2SFS4SP86" alt="Coverage status"></a>
	<a href="http://java.oracle.com"><img src="https://img.shields.io/badge/java-11+-D0008F.svg" alt="Java compatibility"></a>
	<a href="https://mvnrepository.com/artifact/io.github.wniemiec-io-java/argument-file"><img src="https://img.shields.io/maven-central/v/io.github.wniemiec-io-java/argument-file" alt="Maven Central release"></a>
	<a href="https://github.com/wniemiec-io-java/argument-file/blob/master/LICENSE"><img src="https://img.shields.io/github/license/wniemiec-io-java/argument-file" alt="License"></a>
</p>
<hr />

## ❇ Introduction
To shorten or simplify the javac command, you can specify one or more files that contain arguments to the javac command (except -J options). This enables you to create javac commands of any length on any operating system. An argument file can include javac options and source file names in any combination.

## ❓ How to use
1. Add one of the options below to the pom.xml file: 

#### Using Maven Central (recomended):
```
<dependency>
  <groupId>io.github.wniemiec-io-java</groupId>
  <artifactId>argument-file</artifactId>
  <version>LATEST</version>
</dependency>
```

#### Using GitHub Packages:
```
<dependency>
  <groupId>wniemiec.io.java</groupId>
  <artifactId>argument-file</artifactId>
  <version>LATEST</version>
</dependency>
```

2. Run
```
$ mvn install
```

3. Use it
```
[...]

import wniemiec.io.java.ArgumentFile;

[...]

Path workingDirectory = Path.of(System.getProperty("java.io.tmpdir"));
String filename = "argfile";

argumentFile = new ArgumentFile(workingDirectory, filename);
argumentFile.create(List.of(
	Path.of("C:", "Foo", "Bar", "file1.jar"),
	Path.of("C:", "Foo", "Bar", "file2.jar"),
	Path.of("C:", "Foo")
);

[...]
```

> javac @argfile.txt


## 📖 Documentation
|        Property        |Parameter type|Return type|Description|Default parameter value|
|----------------|-------------------------------|-----|------------------------|--------|
|create |`paths: List<Paths>`|`Path`|Generates argument file from a list of paths.| - |
|delete |`void`|`void`|Removes argument-file| - |
|exists |`void`|`boolean`|Checks if the argument-file has created.| - |

## 🚩 Changelog
Details about each version are documented in the [releases section](https://github.com/williamniemiec/wniemiec-io-java/argument-file/releases).

## 🤝 Contribute!
See the documentation on how you can contribute to the project [here](https://github.com/wniemiec-io-java/argument-file/blob/master/CONTRIBUTING.md).

## 📁 Files

### /
|        Name        |Type|Description|
|----------------|-------------------------------|-----------------------------|
|dist |`Directory`|Released versions|
|docs |`Directory`|Documentation files|
|src     |`Directory`| Source files|
