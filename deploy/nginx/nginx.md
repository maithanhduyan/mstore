# NginX configuaration

> admin.mstore.com

```
    server {
        listen       8888;
        listen       12.0.0.1:8888;
        server_name  admin  mstore.com admin.mstore.com  ;

        location / {
            proxy_pass   http://127.0.0.1:8888;
        }
    }
```

shop.mstore.com

```
server {
        listen       80;
        listen       127.0.0.1:8080;
        server_name  shop  mstore.com  ;

        location / {
            proxy_pass   http://127.0.0.1:8080;
        }
    }
```
