package controller

import (
	"github.com/chrislcontrol/event-driven-architecture/balances-service/internal/entity"
	"github.com/chrislcontrol/event-driven-architecture/balances-service/internal/usecase"
	"github.com/gin-gonic/gin"
	"net/http"
)

func NewBalanceController(getBalance *usecase.GetBalance) *BalanceController {
	return &BalanceController{getBalance: getBalance}
}

type BalanceController struct {
	getBalance *usecase.GetBalance
}

func (bc *BalanceController) GetBalance(ctx *gin.Context) {
	var input struct {
		AccountNumber int `form:"accountNumber" binding:"required"`
		AccountBranch int `form:"accountBranch" binding:"required"`
	}
	if err := ctx.ShouldBindQuery(&input); err != nil {
		ctx.JSON(http.StatusUnprocessableEntity, gin.H{"error": err.Error()})
		return
	}

	account := entity.Account{
		Number: input.AccountNumber,
		Branch: input.AccountBranch,
	}
	balance := bc.getBalance.Execute(&account)
	if balance == nil {
		ctx.JSON(http.StatusNoContent, gin.H{})
		return
	}

	ctx.JSON(http.StatusOK, gin.H{"balance": *balance})
}
