<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>阅读练习</title>
    <script src="https://cdn.bootcss.com/react/16.10.2/umd/react.production.min.js"></script>
    <script src="https://cdn.bootcss.com/react-dom/16.10.2/umd/react-dom.production.min.js"></script>
    <script src="https://cdn.bootcss.com/babel-standalone/6.26.0/babel.min.js"></script>
    <script src="https://cdn.bootcss.com/moment.js/2.24.0/moment.min.js"></script>
    <script src="https://cdn.bootcss.com/antd/3.23.6/antd.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/antd/3.23.6/antd.min.css"/>
    <script>
        Date.prototype.format = function (fmt) {
            const o = {
                "M+": this.getMonth() + 1, //月份
                "d+": this.getDate(), //日
                "h+": this.getHours(), //小时
                "m+": this.getMinutes(), //分
                "s+": this.getSeconds(), //秒
                "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                "S": this.getMilliseconds() //毫秒
            };
            if (/(y+)/.test(fmt)) {
                fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            }
            for (var k in o) {
                if (new RegExp("(" + k + ")").test(fmt)) {
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                }
            }
            return fmt;
        }
    </script>
</head>
<body>
<div id="app"></div>
<script type="text/babel">


    const {PageHeader, Tabs, Button, Statistic, Descriptions, Layout, Menu, Icon, notification, Typography, Divider, Radio, Row, Col, message, Empty, Modal} = antd;

    const {TabPane} = Tabs;
    const {SubMenu} = Menu;
    const {Header, Content, Footer, Sider} = Layout;
    const {Title, Paragraph, Text} = Typography;

    class Reading extends React.Component {
        constructor() {
            super();
            this.state = {
                readingData: [],
                choose: [{}, {}, {}, {}],
                currentReading: 0,
                currentItem: 0,
                isReading: false,
                time: "60:00",
                total: 0,
                visible: false
            };
        }

        componentDidMount = () => {
            this.handleAskData();
        };

        handleTimeDown = (endDateStr) => {
            const {isReading} = this.state;
            //结束时间
            let endDate = new Date(endDateStr);
            //当前时间
            let nowDate = new Date();
            //相差的总秒数
            let totalSeconds = parseInt((endDate - nowDate) / 1000);
            //天数
            let days = Math.floor(totalSeconds / (60 * 60 * 24));
            //取模（余数）
            let modulo = totalSeconds % (60 * 60 * 24);
            //小时数
            let hours = Math.floor(modulo / (60 * 60));
            modulo = modulo % (60 * 60);
            //分钟
            let minutes = Math.floor(modulo / 60);
            //秒
            let seconds = modulo % 60;
            //输出到页面
            this.setState({
                time: minutes + ":" + seconds
            });
            //延迟一秒执行自己
            isReading ? setTimeout(() => {
                this.handleTimeDown(endDateStr)
            }, 1000) : ""
        }

        handleAskData = () => {
            $.ajax({
                url: "./reading/getData",
                type: "get",
                dataType: "json",
                success: (res) => {
                    res = JSON.parse(res);
                    res.map(item => {
                        let rd = null;
                        rd = {
                            id: item.id,
                            content: item.content,
                            question: []
                        };
                        $.ajax({
                            url: "./reading/getQuestion",
                            type: "POST",
                            data: {
                                id: item.id
                            },
                            dataType: "json",
                            success: (res) => {
                                res = JSON.parse(res);

                                res.map(itemQ => {
                                    let qu = null;
                                    qu = {
                                        id: itemQ.id,
                                        content: itemQ.readingQuestion,
                                        choose: []
                                    };
                                    $.ajax({
                                        url: "./reading/getChoose",
                                        type: "POST",
                                        data: {
                                            id: itemQ.readingId
                                        },
                                        dataType: "json",
                                        success: (res) => {
                                            res = JSON.parse(res);
                                            qu.choose = {
                                                id: res.id,
                                                r_a: res.readingChooseA,
                                                r_b: res.readingChooseB,
                                                r_c: res.readingChooseC,
                                                r_d: res.readingChooseD,
                                                result: res.result
                                            };
                                            rd.question.push(qu);
                                            this.saveReadingData(rd);
                                        },
                                        error: () => {
                                            console.log("error");
                                        }
                                    })
                                });
                            },
                            error: () => {
                                console.log("error");
                            }
                        });
                    });
                },
                error: () => {
                    console.log("error");
                }
            })
        };
        saveReadingData = (data) => {
            const {readingData} = this.state;
            let diff = true;
            for (let i = 0; i < readingData.length; i++)
                if (readingData[i].id === data.id) {
                    diff = false;
                    readingData[i] = data;
                    break;
                }
            if (diff) {
                readingData.push(data)
            }
            this.setState({
                readingData: readingData,
                currentReading: readingData[0].id - 1,
                currentItem: 0
            })
        };
        renderContent = (column = 2) => (
            <Descriptions size="small" column={column}>
                <Descriptions.Item label="当前用户">userName</Descriptions.Item>
                <Descriptions.Item label="当前时间">{new Date().format("yyyy-MM-dd hh:mm:ss")}</Descriptions.Item>
                <Descriptions.Item label="注意事项">
                    做完全题目才可以提交题目
                </Descriptions.Item>
            </Descriptions>
        );
        handleShowWhichReading = (pre, after) => {
            const {readingData, currentItem, choose, currentReading} = this.state;
            if (pre) {
                this.setState({
                    currentItem: currentItem - 1
                }, () => {
                    this.setState({
                        currentReading: readingData[currentItem].id - 1
                    })
                })
            } else if (after) {
                if (Object.keys(choose[currentItem]).length !== readingData[currentItem].question.length) {
                    message.warning('请答完当前题目');
                } else {
                    this.setState({
                        currentItem: currentItem + 1
                    }, () => {
                        this.setState({
                            currentReading: readingData[currentItem].id - 1
                        })
                    })
                }
            } else {
                this.setState({
                    currentReading: readingData[currentItem].id - 1
                })
            }
        };
        getCurrentReading = () => {
            const {readingData, choose, currentItem} = this.state;
            let id = currentItem;
            const radioStyle = {
                display: 'block',
                height: '30px',
                lineHeight: '30px',
            };
            const handleSaveChoose = (id, item, value) => {
                choose[id][item] = value;
                this.setState({
                    choose: choose
                })
            };
            return readingData.length === 4 && readingData[id] ? (
                <div>
                    <Typography style={{
                        padding: "48px 48px"
                    }}>
                        <Title>阅读练习{(id + 1)}</Title>
                        <Paragraph>
                            <Text strong style={{
                                whiteSpace: " pre-line",
                                fontSize: "12px"
                            }}>
                                {readingData[id].content}}
                            </Text>
                        </Paragraph>
                        <Divider/>
                        <Title level={3}>问题</Title>
                        {
                            readingData[id].question.map((item, index) => {
                                console.log(choose[id][index + 1]);
                                return (
                                    <Paragraph>
                                        <Text strong={true}>
                                            {(index + 1) + "." + item.content}
                                        </Text>
                                        <br/>
                                        <Radio.Group
                                            onChange={(e) => {
                                                handleSaveChoose(id, index + 1, e.target.value);
                                            }}
                                            value={choose[id][index + 1] || null}
                                        >
                                            <Radio style={radioStyle} value={"a"}>
                                                {"A." + item.choose.r_a}
                                            </Radio>
                                            <Radio style={radioStyle} value={"b"}>
                                                {"B." + item.choose.r_b}
                                            </Radio>
                                            <Radio style={radioStyle} value={"c"}>
                                                {"C." + item.choose.r_c}
                                            </Radio>
                                            <Radio style={radioStyle} value={"d"}>
                                                {"D." + item.choose.r_d}
                                            </Radio>
                                        </Radio.Group>
                                    </Paragraph>
                                )
                            })
                        }
                    </Typography>
                    <Row>
                        <Col offset={20} span={4}>
                            {currentItem === 0 ? "" :
                                <Button type="default" onClick={() => this.handleShowWhichReading(true, false)}>
                                    <Icon type="left"/>
                                    上一道题
                                </Button>}
                            {
                                currentItem === (readingData.length - 1) ? "" :
                                    <Button style={{
                                        marginLeft: 6
                                    }} type="primary" onClick={() => this.handleShowWhichReading(false, true)}
                                    >
                                        下一道题
                                        <Icon type="right"/>
                                    </Button>
                            }
                        </Col>
                    </Row>
                </div>
            ) : ""
        }
        extraContent = () => {
            const {time} = this.state;
            return (
                <div
                    style={{
                        display: 'flex',
                        width: 'max-content',
                        justifyContent: 'flex-end',
                    }}
                >
                    <Statistic
                        title="上次得分"
                        value={"0" + "分"}
                        style={{
                            marginRight: 32,
                        }}
                    />
                    <Statistic
                        title="剩余计时"
                        value={time}
                    />
                </div>
            )
        };

        render() {
            const {readingData, isReading, visible, total} = this.state;
            console.log(readingData);
            const notiWaring = (key, item) => {
                if (key !== item)
                    notification["warning"]({
                        message: '消息提示',
                        description: "站点还在建设中"
                    });
            };
            const handleOver = () => {
                const {choose, readingData, time} = this.state;
                let le = 0;
                for (let i = 0; i < readingData.length; i++) {
                    le += parseInt(Object.keys(choose[i]).length)
                }
                if (le === 15)
                    this.setState({
                        total: Math.floor(Math.random() * (15 - 1) + 1)
                    }, () => {
                        this.setState({
                            visible: true
                        });
                        // $.ajax({
                        //     url: "./reading/getChoose",
                        //     type: "POST",
                        //     data: {
                        //         id: 1,
                        //         total: this.state.total
                        //     },
                        //     dataType: "json",
                        //     success: (res) => {
                        //         res = JSON.parse(res);
                        //         qu.choose = {
                        //             id: res.id,
                        //             r_a: res.readingChooseA,
                        //             r_b: res.readingChooseB,
                        //             r_c: res.readingChooseC,
                        //             r_d: res.readingChooseD,
                        //             result: res.result
                        //         };
                        //         rd.question.push(qu);
                        //         this.saveReadingData(rd);
                        //     },
                        //     error: () => {
                        //         console.log("error");
                        //     }
                        // })
                    });
                else {
                    notification["warning"]({
                        message: '消息提示',
                        description: "请答完全部题目再提交"
                    });
                }
            };
            return (
                <Layout>
                    <Header className="header">
                        <Menu
                            theme="dark"
                            mode="horizontal"
                            defaultSelectedKeys={['4']}
                            style={{lineHeight: '64px'}}
                            onClick={({item, key, keyPath, domEvent}) => notiWaring(key, "4")}
                        >
                            <Menu.Item key="1">单词背诵</Menu.Item>
                            <Menu.Item key="2">写作练习</Menu.Item>
                            <Menu.Item key="3">英语扩展</Menu.Item>
                            <Menu.Item key="4">阅读练习</Menu.Item>
                        </Menu>
                    </Header>
                    <Content>
                        <Layout style={{padding: '24px 0', background: '#fff'}}>
                            <Sider width={200} style={{
                                background: '#fff'
                            }}>
                                <Menu
                                    mode="inline"
                                    defaultSelectedKeys={['1']}
                                    defaultOpenKeys={['sub1']}
                                    style={{height: '100%'}}
                                    onClick={({key, domEvent}) => notiWaring(key, "1")}
                                >
                                    <SubMenu
                                        key="sub1"
                                        title={
                                            <span>
                                                <Icon type="user"/>
                                                我的信息
                                                </span>
                                        }
                                    >
                                        <Menu.Item key="1">学习</Menu.Item>
                                        <Menu.Item
                                            key="2"
                                        >学习记录</Menu.Item>
                                    </SubMenu>
                                    <SubMenu
                                        key="sub2"
                                        title={
                                            <span>
        <Icon type="laptop"/>
        我的收藏
        </span>
                                        }
                                    >
                                        <Menu.Item key="5">单词收藏</Menu.Item>
                                        <Menu.Item key="6">写作收藏</Menu.Item>
                                        <Menu.Item key="7">拓展收藏</Menu.Item>
                                        <Menu.Item key="8">阅读收藏</Menu.Item>
                                    </SubMenu>
                                    <SubMenu
                                        key="sub3"
                                        title={
                                            <span>
                                                <Icon type="notification"/>
                                                消息
                                                </span>
                                        }
                                    >
                                        <Menu.Item key="9">站内信</Menu.Item>
                                        <Menu.Item key="10">@我</Menu.Item>
                                        <Menu.Item key="11">个人设置</Menu.Item>
                                    </SubMenu>
                                </Menu>
                            </Sider>
                            <Content style={{padding: '0 24px'}}>
                                <div style={{
                                    background: '#fff',
                                    padding: 24,
                                    minHeight: "90vh"
                                }}>
                                    <div>
                                        <PageHeader
                                            style={{
                                                border: '1px solid rgb(235, 237, 240)',
                                            }}
                                            title="阅读练习"
                                            subTitle="在此进行您的阅读练习"
                                            extra={[
                                                isReading ?
                                                    (
                                                        <div>
                                                            <Button type="dashed" key="3" onClick={() => {
                                                                this.setState({
                                                                    choose: [{}, {}, {}, {}],
                                                                    currentReading: 0,
                                                                    currentItem: 0,
                                                                    isReading: false,
                                                                    time: "60:00"
                                                                })
                                                            }}>重新答卷</Button>
                                                            <Button key="1" type="primary" onClick={handleOver}>
                                                                提交
                                                            </Button>
                                                            <Modal
                                                                title="Basic Modal"
                                                                visible={visible}
                                                                onOk={() => {
                                                                    this.setState({
                                                                        choose: [{}, {}, {}, {}],
                                                                        currentReading: 0,
                                                                        currentItem: 0,
                                                                        isReading: false,
                                                                        time: "60:00",
                                                                        visible: false
                                                                    })
                                                                }}
                                                                onCancel={() => {
                                                                    this.setState({
                                                                        choose: [{}, {}, {}, {}],
                                                                        currentReading: 0,
                                                                        currentItem: 0,
                                                                        isReading: false,
                                                                        time: "60:00",
                                                                        visible: false
                                                                    })
                                                                }}
                                                            >
                                                                <p>得分</p><p>{total}</p>
                                                            </Modal>)
                                                        </div>
                                                    ) :
                                                    (
                                                        <Button key="2" type="primary" onClick={() => {
                                                            this.setState({
                                                                isReading: true
                                                            });
                                                            let time = new Date().getTime() + 3600 * 1000;
                                                            this.handleTimeDown(time);
                                                        }}>
                                                            开始练习
                                                        </Button>),
                                            ]}
                                            footer={
                                                <Tabs defaultActiveKey="1">
                                                    <TabPane tab="练习" key="1">
                                                        {isReading ? this.getCurrentReading(0) : ""}
                                                    </TabPane>
                                                </Tabs>
                                            }
                                        >
                                            <ContentOwn>
                                                {this.renderContent()}
                                            </ContentOwn>
                                        </PageHeader>
                                    </div>
                                </div>
                            </Content>
                        </Layout>
                    </Content>
                    <Footer style={{textAlign: 'center'}}>背背+ ©2019 Created by 软工172-1</Footer>
                </Layout>
            )
        }
    }


    const
        ContentOwn = ({children, extra}) => {
            return (
                <div className="content">
                    <div className="main">{children}</div>
                    <div className="extra">{extra}</div>
                </div>
            );
        };


    ReactDOM
        .render(
            <Reading/>,
            document
                .getElementById(
                    "app"
                )
        )
    ;
</script>
</body>
</html>
