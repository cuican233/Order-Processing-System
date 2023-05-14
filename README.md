# Order-Processing-System

一个基于java的订单处理系统的设计与实现

## 该系统有以下需求：

订单处理系统用于处理买家通过Web站点所下订单。该系统包括买家和商家两个角色。该系统的主要功能如下：

- 买家/商家信息管理：主要是买家/商家基本信息的管理，包括买家/商家基本信息的查看与修改（即增删改查），其中买家/商家信息包括姓名、电话、邮寄地址等。买家/商家基本信息存储在买家/商家信息表中；
- 商品信息管理：主要是商品基本信息的查看与修改，其中商品基本信息包括商品的价格和可订购数量等；
- 商家的商品信息管理：主要是记录商家所拥有的商品的类别和数量；
- 订单管理：主要是订单信息管理。订单是根据买家的订购请求及该买家信息产生。订单信息存储在订单记录表中；
- 发货单管理：主要是商家依据订单记录表和客户信息表，逐一生成发货单。每个发货单分配一个物流单号；
- 发货单状态管理：商家更新发货单的物流状态；该发货单的状态会显示到买家的订单状态上。

选用技术：Java；

数据管理使用数组；自学数据库访问技术，自选数据库系统管理数据；

软件集成开发环境（IDE）：IDEA；
