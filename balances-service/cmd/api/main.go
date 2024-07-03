package main

import (
	"github.com/chrislcontrol/event-driven-architecture/balances-service/internal/router"
	"github.com/gin-gonic/gin"
)

const (
	host = "127.0.0.1"
	port = "8081"
)

func main() {
	server := gin.Default()
	router.Route(server)
	err := server.Run(host + ":" + port)
	if err != nil {
		panic(err)
	}
}
