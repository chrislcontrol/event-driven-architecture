package entity

import (
	"github.com/aws/aws-sdk-go-v2/feature/dynamodb/attributevalue"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
)

type Account struct {
	Number int `DynamoDB:"number"`
	Branch int `DynamoDB:"branch"`
}

func (account Account) GetKey() map[string]types.AttributeValue {
	number, err := attributevalue.Marshal(account.Number)
	if err != nil {
		panic(err)
	}

	branch, err := attributevalue.Marshal(account.Branch)
	if err != nil {
		panic(err)
	}

	return map[string]types.AttributeValue{"number": number, "branch": branch}
}
