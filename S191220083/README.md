# Readme

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

## 任务一

1.example 类图

![](http://www.plantuml.com/plantuml/png/LLFRRjim37ttL_3Hk_WFzj0LoBe2GrCaQpQWw8EIS9unHJ8a6bjs-VUH9YtRJpxdI3oyKBx9v18D5r-TlCiPFdK1gpyLG0CgFCRSKHU3I8Kylq1lCFF16-W7gZdK7Js-xGAz6aKJe4MgYxYdr8KMA2geLrVPb-BxbDoLzNzLjIv1wogsOs16CZxbbq3EXkcREo6OAA5wUpAh9w05J0pQnHKzOZDH3yuFk2ph3l4t9dDM0lGTJPPAzp4HYtdyM069LAtringAxm8-zT88YjwOBjDsAUEZTw5MIO_n5vu6GjCW4_PZVHY62zp58PrjPD92AgWjw2ZPzQQqE8BRwyw57sLX6YkAqlpJzML0Ou2an40TNM7xi9dWvozRAFZZRbCEFcoVTWNV7ug-l_zQuEQmUQZO39h6-X2xcOZVJCLnPk8vCtPT4F6TwVnCR5EsIn_TMVf_Vh6M-R1UBafc9SjOleRRuNZqkF1fOBG0jzWaz1nLnYWvz6zX5rawl6wQ-RLF02AhvI7RGnFDaka7tlrbQLM5XV19QVa6mvb_zly0)

时序图

![](http://www.plantuml.com/plantuml/png/SoWkIImgAStDuKeiBSdFAyrDIYtY2avEpKjLqBLJKCZ9p4krKdW-PVwpZWdcJtQiUhAtz_dUTLn0OR2yUtvfKOgLmik6MI_sj_javYKcvQG-wrlwj7-nmhCf-u0gGNh0YfvsR7Yoe_VfX1we2GWxIZ9ItLDJgrABOFP0U0W5nVb59GZP9piQW6OwbIO1hGe6oZoVrVAiRzBJNVtFfkryjdagLdEH5RnO1t8Nq2244LnmfSZMFUrQy6BlNg2-f_tRd-nV-AnnFNPrB_RFVh6m1s855qWG8eqm7gXaG_FpAIkGNO5g5DZDC6S2FVHYtOQdUv6yKbwK2R5gt-IdxRkWiWwfUId0U0C0)



2.从面向对象来分析：

*为什么Gourd不直接在类内定义setPosition等方法，而要采用Linable接口呢*？

这样做可以使得程序拓展性增强，通过Linable接口，还可以写除了葫芦娃之外其他的生物的排序，把接口作为规定动作的列表，具体实现留给其他类。

*在Position中有setLinable方法，在Linable中有setPosition方法，这样设计不冗余吗？*

不冗余，Linable实例化以后是被排序的对象，setPosition是在告知被排序的对象它当前的位置，Position是Line中的信息，setLinable是在告知Line当前某个位置的被排序的实体的信息，这是一种信息的沟通



这里的面向对象把不同的功能模块彻底分割，比如在排序调换位置的时候，是通过对象之间的互相交互，信息发送来完成的，而不是Scene来进行操作；同时，进行了抽象，如interface，为之后的改进和替换留下余地。除了Linable的设计之外，Sorter的实例化也允许用不同的排序方法来实现。

内部类的使用使得代码更加简洁，不需要再增加一个文件存放Position，同时也增加了可读性，因为这个属性是与Line紧密相关的，且主要在Line内有意义。利用内部类能访问到所在外部类的空间的特性，进行了信息的沟通，而没有破坏Line类的封装。

可改进之处：

如果不巧不需要排序，那么getPlan会得到空字符串，execute方法会处理空串，而原本的框架没有对这一情况进行处理，导致抛出异常。可以在plan为空串的时候输出不需要排序。



## 任务二

基于example的代码，需要做出以下的修改：

+ 修复不需要排序的情况；
+ 用类来实现256个妖怪排序，其中可以采用群体-个体的思路，个体作为内部类，以模仿之前用枚举的时候枚举的各项是实例化的代码结构；
+ 在实现妖怪的时候，利用随机数调整赋予颜色和位置的算法；
+ 增加排序的算法；

![](http://www.plantuml.com/plantuml/png/SoWkIImgAStDuShCAqajIajCJbNmoSnBJCf9hQxbuW8oKnMqT7KL0lABCqioy_EuO0o5VA0eL2KNbtjgQbLg4LWiEBy8Q10NX5AmgG4AEPKc0LLXaGWipKpEnYBkaPfO01NcSil9Jyuk1Zl2Dp-l62G6jHQa5Y7ea9gN0lG70000)





[![asciicast](https://asciinema.org/a/437906.svg)](https://asciinema.org/a/437906)



## 任务三

需要在保证尽可能少的修改代码的情况下增加一个矩阵类，使得妖怪们排成方阵但是排序是一起排序。

+ Matrix直接调用了Line的一些方法，但是为了不改动之前的Sorter 在排序上需要还原成Line[]
+ Matrix有Line[]，体现分行的显示
+ Geezer中需要参照lineUp方法给Matrix设计相应的方法，实际上只需要修改传入数据和显示的部分

![](http://www.plantuml.com/plantuml/png/RP2zJiKm34PtFuL7VjGtOBWm0CEj1Eg86D9WIjGG8yULWD9tnqtQhPETu_CbaKzPdUZq6I4a9Nbtdl0SakiZpGluw7B6rgc4xnaGhzSPlRnYj98DD6YnSZfJ6lIZE9tfQK3bsbnShdI_rSBAjoBkn_W2HWclcWQVE0SDd61la8rk8O07eb-ImZeM9O5QyERFqDtKctKmU9w27m_u8xcl3SDzP3_cyecMKrxPzcnrTmXr3qKqWU14wSqszmy0)

[![asciicast](https://asciinema.org/a/437941.svg)](https://asciinema.org/a/437941)



参考资料：

> https://qastack.cn/codegolf/92466/rgb-gradients-generation 渐变生成
>
> https://qastack.cn/programming/43044/algorithm-to-randomly-generate-an-aesthetically-pleasing-color-palette 更加柔和的渐变颜色生成
>
> https://blog.csdn.net/sophie2805/article/details/82724820 生成不重复的随机数
