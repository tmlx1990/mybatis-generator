#	使用说明
## 	一、工具介绍
   本工具可以通过读取固定PDM文件，获取数据库中相应列名对应的中文名称，然后在生成实体类的使用添加到相应字段上。

##  二、使用方法
   1. 导入项目到Eclipse中。
   2. 配置Maven打包命令  
   `mvn clean package`
   3. 将target打包后的jar文件、相应的lib文件夹及项目中的mybatis-generator-config_1_0.dtd拷贝到官方下载的mybatis-generator目录下。
   4. 替换原有mybatis-generator-core-*.*.jar包。
   5. 将要生成的表对应的PDM放到mybatis-generator所在目录。配置generator.xml增加pdm路径信息，可以参考项目中的generatorConfig.xml。  
   `<pdmUrl url="./1.pdm"></pdmUrl>`
   6. 执行run.bat文件。等待生成文件。
	

##  三、版本介绍
   1. v1.0版本  
   `增加了读取指定目录pdm进行生成实体类中文功能。`
   2. v1.1版本  
   `将读取pdm文件修改为通过配置进行读取。`
   3. v1.2版本  
   `修改了SerializablePlugin插件。`
   4. v1.3版本  
   `添加了ImportPlugin、AnnotationClassPlugin插件，可以通过配置进行自动加入引入包、类注解的功能。`