package usecase

import (
	"github.com/chrislcontrol/event-driven-architecture/balances-service/internal/entity"
	"github.com/chrislcontrol/event-driven-architecture/balances-service/internal/repository"
)

func NewGetBalance(balanceRepository *repository.BalanceRepository) *GetBalance {
	return &GetBalance{
		balanceRepository: balanceRepository,
	}
}

type GetBalance struct {
	balanceRepository *repository.BalanceRepository
}

func (g *GetBalance) Execute(account *entity.Account) *float64 {
	balance := g.balanceRepository.GetBalance(account)
	if balance == nil {
		return nil
	}

	return &balance.Funds
}
