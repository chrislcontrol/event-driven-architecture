package repository

import (
	"context"
	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/feature/dynamodb/attributevalue"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/chrislcontrol/event-driven-architecture/balances-service/internal/entity"
)

type BalanceRepository struct {
	dbClient *dynamodb.Client
}

func (b *BalanceRepository) GetBalance(account *entity.Account) *entity.Balance {
	balance := entity.Balance{
		Key: account,
	}

	response, err := b.dbClient.GetItem(context.TODO(), &dynamodb.GetItemInput{
		Key:       account.GetKey(),
		TableName: aws.String("balance"),
	})
	if err != nil {
		panic(err)
	}

	err = attributevalue.UnmarshalMap(response.Item, &balance)
	if err != nil {
		panic(err)
	}

	return &balance
}

func NewBalanceRepository(dbClient *dynamodb.Client) *BalanceRepository {
	return &BalanceRepository{dbClient: dbClient}
}
