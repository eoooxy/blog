一直以来都停留在想的阶段，这次终于开始行动了起来。具体示例如本博客所示，为了精简，摒弃一切复杂的模块（其实是复杂的模块我不会😂 原谅我装个比，啊哈哈哈）所用技术，如下
 

 * springboot框架知识
 * redis用到一点点（总感觉不涉及点，心里不好受）
 * 数据库采用的是mysql-5.7
 * 页面模板就是常用的thymeleaf
 * 服务器容器用的是Tomcat8.+

 整个博客分为两大部分：前台展示，后台编辑
 
 * 前台展示部分
 	1. 按照编辑日期从金世到来生依次排序
 	2. 可以根据归档的日期、类别和标签来分来
 	3. 还有游客回复功能，本来是不想做登录之后才可以回复的，但是想想还是做，登录后才可以回复。（从功能还在施工中…） 
 	
 * 后端编辑部分
 	1. 首先文章编辑，这里采用的编辑器是个小巧而强悍的编辑器——[wangeditor](https://github.com/wangfupeng1988/wangEditor)
 	2. 其次就是种类和标签的更新

 所谓麻雀虽小五脏俱全（自夸的），整个项目历时20天，每天断断续续的想起来就写点（没办法啊，中了王者荣耀的毒了）
 
 运行的时候，直接ApplicationConfig 右击运行。新建一个数据库，然后把blog.sql 导进去，然后手动在blog_user表中添加账号密码。之后再修改数据库的配置和redis得配置
 
 具体图片展示这边我就不展示了，前台页面就如本博客所示：
 [大园子的博客](http://doliao.com/)	,后台风格一致，没多大区别，如果你真要想看后台界面的话，那么你就clone下项目自己跑一下吧。

git地址：[https://github.com/eoooxy/blog](https://github.com/eoooxy/blog)
 
 