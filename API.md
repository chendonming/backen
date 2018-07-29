# 总后台API

> 本系统全部采用JSON格式提交

> 本系统的前缀标识```backen```



[TOC]



## 权限管理

### 登录

接口: ```/user/login```

方式: ```POST```

参数: 
```json
{
	"mobile": "xxxxx",
	"password": "123"
}

```

接口返回: 

```json
{
    "code": 200,
    "msg": "成功",
    "data": {
        "uuid": "47c0562c5e744776b61f3489c1e5b1bf",
        "nickname": "测试1",
        "truename": "大张伟",
        "headPic": null,
        "mobile": "15974253641",
        "sex": 1,
        "isRealName": 1,
        "idCard": "430725199610197119",
        "password": "202cb962ac59075b964b07152d234b70",
        "communityId": "1",
        "totalIntegral": 20,
        "integral": 20,
        "status": 1,
        "createTime": "2018-07-28 20:48:24",
        "updateTime": "2018-07-28 20:48:27",
        "roles": [
            {
                "uuid": "69bb65467a4a40a88fc2e42f3672220",
                "name": "大型管理员",
                "description": null,
                "createTime": null,
                "updateTime": null
            },
            {
                "uuid": "50e41d6abb654f7c97b022757ff1d8e6",
                "name": "小型管理员",
                "description": null,
                "createTime": null,
                "updateTime": null
            }
        ],
        "menus": [
            {
                "uuid": "2ec6095845eb4b00b9df3069244d84a8",
                "name": "任务管理",
                "code": "task",
                "createTime": null,
                "updateTime": null,
                "powers": [
                    {
                        "uuid": "15458a40fc6a4de098bb8621deaa0864",
                        "code": "task:add",
                        "meunId": null,
                        "description": null,
                        "createTime": null,
                        "updateTime": null
                    },
                    {
                        "uuid": "37f7b4e881984c9d818c6133f84c5585",
                        "code": "task:del",
                        "meunId": null,
                        "description": null,
                        "createTime": null,
                        "updateTime": null
                    },
                    {
                        "uuid": "cfad135466ad4da8b84ce93b45e0031e",
                        "code": "task:query",
                        "meunId": null,
                        "description": null,
                        "createTime": null,
                        "updateTime": null
                    }
                ]
            },
            {
                "uuid": "f8c2d15acb374a16a03cc881548fbd14",
                "name": "活动管理",
                "code": "activity",
                "createTime": null,
                "updateTime": null,
                "powers": [
                    {
                        "uuid": "784239c65fcb4f1cac028eecda7bbab6",
                        "code": "activity:query",
                        "meunId": null,
                        "description": null,
                        "createTime": null,
                        "updateTime": null
                    }
                ]
            }
        ]
    }
}

```

### 查询所有的角色

接口: ```/permiss/role/query```

方式: ```POST```

参数: 无

接口返回: 


### 角色新增

接口: ```/permiss/role/add```

参数:
```json
{
	"name": "xxxx", //必填
	"description": "" //描述: 选填
}

```

### 为角色赋权
接口： ```/permiss/rolepower/givePermiss```


方式: ```POST```

参数: 
```json
[
	{
		"roleId": "12233", //角色id
		"powerId": "1111111" //权限id
	},
	{
		"roleId": "12233",
		"powerId": "1233333"
	}

]

```

如果想清空角色的所有权限，请输入参数:
```json
[
	{
		"roleId": "1111",//角色id必填
		"powerId": "",//保持powerId为空即可
	}
]
```

### 为用户分配角色

接口： ```/permiss/role/allocationRole```

方式: ```POST```

参数: 
```json
[
	{
		"roleId": "12233", //角色id
		"userId": "1111111" //用户id
	},
	{
		"roleId": "12233",
		"userId": "1233333"
	}

]

```


操作同 ```为角色赋权```

### 查询所有的菜单

接口： ```/permiss/menus/queryAll```

方式： ```GET```

参数: 无


### 查询所有权限

接口: ```/permiss/powers/queryAll```

方式: ```GET```

参数： 无
