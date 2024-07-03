package router

import (
	"github.com/chrislcontrol/event-driven-architecture/balances-service/internal/factory"
	"github.com/gin-gonic/gin"
	"net/http"
)

const apiV1 = "/api/v1"

func Route(server *gin.Engine) {
	dependencies := factory.NewDependencies()

	// Ping
	server.GET(apiV1+"/ping", func(ctx *gin.Context) {
		ctx.JSON(http.StatusOK, gin.H{
			"message": "pong",
		})
	})

	// Balances
	server.GET(apiV1+"/balances", dependencies.BalanceController.GetBalance)
}
