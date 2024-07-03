package entity

import "google.golang.org/protobuf/types/known/timestamppb"

type Balance struct {
	Key     *Account
	Funds   float64
	Version timestamppb.Timestamp
}
