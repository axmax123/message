# mesage
Install RabbitMQ in windows :
1. Download and install ERlang http://erlang.org/download/otp_win64_22.3.exe
2. Downlaod and install RabbitMQ https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.8.8/rabbitmq-server-3.8.8.exe
3. Go to RabbitMQ Server install Directory C:\Program Files\RabbitMQ Server\rabbitmq_server-3.8.3\sbin
4. Run command rabbitmq-plugins enable rabbitmq_management
5. Open browser and enter http://localhost:15672/ to redirect to RabbitMQ Dashboard
6. Also we can Open it with IP Address http://127.0.0.1:15672
7. Login page default username and password is guest
8. After successfully login you should see RabbitMQ Home page

Exchangr: 
1. fanout: http://localhost:9292/fanout/sendmsg?exchange=fanout-exchange&msg=serminarrabbitmq
2. direct: http://localhost:9292/direct/sendmsg?exchange=fanout-exchange&routingKey=queue.collegestudents&msg=rabbitmqexchangedirect1213

RabbitMQ Exchange Topic:
1. http://localhost:9291/order/car/god
  JSON: {
    "name":"god",
    "address":"31 Lê Văn Thứ",
    "qty":1,
    "price":10
}

2. http://localhost:9292/order/food/thit
  JSON:{
    "food":"thịt nướng",
    "qty":1,
    "price":10
}
 

