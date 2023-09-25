# cinemaSystem
影院管理系统
本项目一共有十一个类
一、LoginWindow 类是一个登录窗口类，它包含了管理者(Admin)、经理
(Manage)、前台(Reception)和用户(User)的实例以及电影(Movie)和场(Session)的
列表。具体分析如下：
属性：
manage：Manage 类型的对象，用于经理的操作。
admin：Admin 类型的对象，用于管理员的操作。
reception：Reception 类型的对象，用于前台的操作。
users：User 类型的列表，保存用户的信息。
user：User 类型的对象，用于用户的操作。
movies：Movie 类型的列表，保存电影的信息。
sessions：Session 类型的列表，保存场次的信息。
方法：
showLogin()：显示登录选项的方法，打印身份选择菜单。
Window()：登录窗口的主要逻辑方法，接受用户输入并根据选择调用相应的
操作方法。在 Window()方法中，通过使用 Scanner 类获取用户输入，然后根据输
入选择不同的角色进行登录操作。如果输入为"0"，则退出循环结束程序。根据
输入的不同，分别调用 admin、manage、reception 和 user 对象的登录操作方法，
来完成相应角色的具体功能。
二、Person 类一个表示个人的类，包含了与用户交互相关的方法和一些辅助
方法。具体分析如下：
属性：
in：Scanner 类型的对象，用于接收用户输入。
account：String 类型的属性，保存用户的账号。
password：String 类型的属性，保存用户的密码。
方法：
inputUserName()：输入用户名的方法，提示用户输入用户名，并返回用户输
入的值。
inputPassWord()：输入密码的方法，提示用户输入密码，并返回用户输入的
值。
showMovie(List<Movie> movies)：显示电影列表的方法，遍历传入的电影列
表，并调用每个电影对象的 show()方法进行展示。
inputMovieName()：输入片名的方法，提示用户输入片名，并返回用户输入
的值。
showSession(List<Session> list)：显示场次列表的方法，遍历传入的场次列表，
并调用每个场次对象的 showCinemaSession()方法进行展示。
SearchMovie(List<Movie> movies)：搜索电影的方法，根据用户输入的片名，
在电影列表中查找匹配的电影并进行展示。
SearchSession(List<Session> list)：搜索场次的方法，根据用户输入的片名，
在场次列表中查找匹配的场次并进行展示。
LoginOperate()：登录操作方法，提示用户输入用户名和密码，并与对象的
account 和 password 属性进行比较，如果匹配成功则显示登录成功，否则提示密
码错误并重新调用 LoginOperate()方法。
inputPosition()：输入放映厅位置的方法，提示用户输入放映厅位置，并返回
用户输入的值。
inputTime()：输入时间段的方法，提示用户输入时间段，并返回用户输入的
值。
三、Admin 类，继承自 Person 类，作为管理员的用户类型。类中有以下属性和
方法：
属性：
in：Scanner 类型对象，用于接收用户输入。
users：List<User>类型的列表，保存所有用户的信息。
方法：
getPassword() / setPassword()：获取/设置管理员密码的方法。
Admin()：构造方法，初始化管理员账户名和密码。
showChoice(List<User> list)：显示管理员选项并处理用户输入，根据用户输
入执行相应的操作，如重置管理员密码、重置用户密码、显示用户信息、查询用
户信息和删除用户信息等。
ShowUser(List<User> users)：显示所有用户的信息，遍历所有用户并调用他
们的 showUserInformation()方法。
SearchUser(List<User> users)：根据输入的用户名查询用户信息，遍历所有用
户并在找到匹配用户时调用其 showUserInformation()方法。
updatePassword()：更新用户密码，根据输入的用户名找到匹配用户并让用户
输入新密码，然后更新用户密码。
revisePassword()：更改管理员密码，让管理员输入新密码并更新密码。
removeUsr()：移除用户信息，让管理员输入用户名称并在找到匹配用户时询问管
理员是否确认删除，如果确认则从用户列表中移除该用户。
四、用户类（User）的定义，继承自一个人类（Person）。该类包含了用户的各
种属性和方法，用于电影票购买和管理。
属性包括：
nowSession: 当前电影场次
users: 用户列表
movies: 电影列表
sessions: 电影放映场次列表
ticketId: 购票 ID 列表
histories: 购物历史列表
isLogin: 是否登录
in: 输入扫描器
userId: 用户 ID
BuyTicketsNumber: 购票数量
phoneNumber: 手机号码
sum: 消费总金额
userLevel: 用户级别
buyTickets: 电影票个数
password: 密码
email: 邮箱
Id: 用户 ID
count: 登录次数
方法包括：
getUsername()和 getPassword()：获取用户名和密码
setUsername()和 setPassword()：设置用户名和密码
getId()和 setId()：获取和设置用户 ID
JudgePassword()：判断密码是否符合规则
ShowChoice()：显示用户选择菜单，并根据选择执行相应的操作
setPassword()：修改密码
Window()：显示用户登录/注册/忘记密码的菜单，并根据选择执行相应的操
作
buyTicket()：购买电影票
pay()：支付购票金额
getSum(int tickets) 方法用于计算购买电影票的总金额。根据用户的级别和票
数，使用不同的折扣计算总金额，并更新用户的级别。返回计算出的总金额。
LoginOperate(String username) 方法用于用户登录操作。用户需要输入用户名
和密码进行登录。如果密码错误，将进行 5 次密码输入尝试，如果超过限制则锁
定账号。
Register() 方法用于用户注册操作。用户需要输入用户名、邮件地址、手机
号和密码。要求用户名长度大于 5 个字符，密码长度大于 8 个字符，必须是大小
写字母、数字和标点符号的组合。
ReSetPassword() 方法用于重置密码操作。用户输入用户名和邮箱后，系统
会生成一个随机密码并发送到用户的邮箱。用户可以选择查看重置后的密码。
takeTicket() 方法用于用户购票操作。用户需要输入电影票的 ID，然后系统
会检查该 ID 是否有效，并从当前场次中取出相应的票。购票记录将被添加到历
史记录中。
showHistory() 方法用于展示用户的购票历史记录。
showUserInformation() 方法用于展示用户的个人信息，包括用户 ID、用户名、
用户级别、消费次数、消费金额、电话和邮箱。
Reception 类，继承了 Person 类，表示前台售票员。
属性：
movies: 电影列表，类型为 List<Movie>，用于存储电影对象。
sessions: 场次列表，类型为 List<Session>，用于存储场次对象。
users: 用户列表，类型为 List<User>，用于存储用户对象。
in: Scanner 对象，用于接收用户输入。
方法：
getPassword(): 获取密码信息，返回一个字符串类型的密码。
setPassword(String password): 设置密码信息，接收一个字符串类型的密码参
数。
Reception(): 构造函数，用于初始化用户名和密码。
showChoice(List<Movie>movies, List<Session>sessions, List<User>users): 展
示前台售票员的操作菜单，并根据用户的选择调用不同的方法。
sellTicket(): 售票操作，包括输入电影名称、时间、位置、购票者用户名和电
话，以及购买电影票的数量。根据输入的信息更新购票者的消费金额和购票次数，
并分配电影票 ID 并添加到场次的电影票列表中。
六、经理类(Manage)继承了一个人员(Person)的类，并实现了管理功能。该类具
有以下属性和方法：
属性:
movies: 电影列表
sessions: 场次列表
in: 用于接收用户输入的 Scanner 对象
方法：
getPassword(): 获取密码
setPassword(String password): 设置密码
Manage(): 构造函数，初始化密码和账号
showChoice(List<Movie>movies,List<Session>sessions): 显示操作选择菜单
filmManagementInterface(String choice): 影片管理操作
SessionManagementInterface(String choice): 排片管理操作
addMovie(): 添加电影
updateMovie(): 更新电影信息
removeMovie(): 删除电影
setCinemaSessions(): 添加场次
updateSession(): 更新场次信息
removeCinemaSession(): 删除场次
这个类实现了电影和场次的管理功能，通过控制台与用户进行交互，根据用
户选择执行相应的操作。其中，电影管理包括添加、搜索、更新和删除电影；排
片管理包括添加、显示、更新和删除场次。
七、电影类(Movie)该类具有以下属性和方法：
属性：
movieName: 电影名
director: 导演
mainSynopsis: 剧情简介
minute: 时长
方法：
show(): 显示电影信息，打印电影名、导演、剧情简介和时长。
该类用于表示电影的基本信息，包括电影名、导演、剧情简介和时长，
并提供了一个 show()方法用于在控制台上显示电影的信息。
八、场次(Session)类。该类具有以下属性和方法：
属性：
pointList: 保存观众选座的位置信息
ticketId: 记录电影票的电子 Id
calendar: 获取当前日期
dayOfWeek: 取得当前日期是星期几
weekDays: 星期几的字符串数组
time: 时间段
price: 价格
movieName: 电影名
position: 放映厅位置
weekday: 周几，默认为当天
cinema: 座位情况，二维数组
isGetTicket: 记录位置是否已被选座或取票
方法：
Session(): 构造函数，初始化座位情况和是否已被选座状态，以及星期几的
初始值。
setCinema(int x, int y): 设置观众选座的位置，并记录是否已被选座。
showCinemaSession(): 打印该场次的基本信息，包括电影名、放映厅、价格
和时间等。
showSeat(): 显示放映厅的座位情况。
getTicket(int x, int y): 通过选座位置取票，将该位置的 isGetTicket 设为-1 表
示该座位已被取票。
该类用于表示一场电影的放映场次信息，包括座位情况、价格、电影名、放
映厅和时间等，并提供了设置座位、显示场次信息、显示座位情况、取票等方法。
九、点（Point）类。该类具有以下属性和方法：
属性：
x: 点的横坐标
y: 点的纵坐标
方法：
Point(int x, int y): 构造函数，初始化点的位置。用于记录影院位置
十、历史记录（History）类。
该类具有以下属性和方法：
属性：
session: 购票场次的信息，类型为 Session 类的对象
Id: 电影票的 Id
buyTicketTime: 购票时间，类型为 Date 类的对象
x、y: 座位的位置坐标
方法：
History(): 构造函数，初始化购票时间为当前时间。
showHistory(): 打印历史记录的详细信息，包括购票时间、电影票 Id、电影
票信息（通过调用 session 的 showCinemaSession 方法打印）、座位坐标等。
该类用于保存用户购票的历史记录信息，包括购票时间、电影票信息、座位
位置等，并提供了显示历史记录的方法。
主类（Main）
创建一个 LoginWindow 对象实例，并将其赋值给变量 loginWindow。调
用 loginWindow 对象的 Window 方法。
