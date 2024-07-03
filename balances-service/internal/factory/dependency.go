package factory

import (
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/chrislcontrol/event-driven-architecture/balances-service/internal/controller"
	"github.com/chrislcontrol/event-driven-architecture/balances-service/internal/db"
	"github.com/chrislcontrol/event-driven-architecture/balances-service/internal/repository"
	"github.com/chrislcontrol/event-driven-architecture/balances-service/internal/usecase"
)

type Dependencies struct {
	DBClient          *dynamodb.Client
	BalanceRepository *repository.BalanceRepository
	BalanceController *controller.BalanceController
	GetBalance        *usecase.GetBalance
}

func NewDependencies() *Dependencies {
	dependencies := &Dependencies{}
	dependencies.DBClient = db.StartDB()
	dependencies.BalanceRepository = repository.NewBalanceRepository(dependencies.DBClient)
	dependencies.GetBalance = usecase.NewGetBalance(dependencies.BalanceRepository)
	dependencies.BalanceController = controller.NewBalanceController(dependencies.GetBalance)

	return dependencies
}
