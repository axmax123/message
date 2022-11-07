# message
Install RabbitMQ in windows :

Download and install ERlang http://erlang.org/download/otp_win64_22.3.exe
Downlaod and install RabbitMQ https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.8.8/rabbitmq-server-3.8.8.exe
Go to RabbitMQ Server install Directory C:\Program Files\RabbitMQ Server\rabbitmq_server-3.8.3\sbin
Run command rabbitmq-plugins enable rabbitmq_management
Open browser and enter http://localhost:15672/ to redirect to RabbitMQ Dashboard
Also we can Open it with IP Address http://127.0.0.1:15672
Login page default username and password is guest
After successfully login you should see RabbitMQ Home page
Exchangr:

fanout: http://localhost:9292/fanout/sendmsg?exchange=fanout-exchange&msg=serminarrabbitmq
direct: http://localhost:9292/direct/sendmsg?exchange=fanout-exchange&routingKey=queue.collegestudents&msg=rabbitmqexchangedirect1213
RabbitMQ Exchange Topic:

http://localhost:9291/order/car/god JSON: { "name":"god", "address":"31 Lê Văn Thứ", "qty":1, "price":10 }

http://localhost:9292/order/food/thit JSON:{ "food":"thịt nướng", "qty":1, "price":10 }
