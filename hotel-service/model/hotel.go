package model

import (
	"time"

	"github.com/google/uuid"
	"gorm.io/gorm"
)

type Hotel struct {
	Id          uuid.UUID      `gorm:"primarykey;id" json:"id"`
	CreatedAt   time.Time      `gorm:"created_at" json:"created_at"`
	UpdatedAt   time.Time      `gorm:"updated_at" json:"updated_at"`
	DeletedAt   gorm.DeletedAt `gorm:"index;deleted_at" json:"deleted_at"`
	ManagerId   int            `gorm:"manager_id" json:"manager_id"`
	Name        string         `gorm:"name" json:"name"`
	Location    HotelAddress   `gorm:"location;foreignKey:HotelId;references:Id;constraint:OnUpdate:CASCADE,OnDelete:CASCADE;" json:"location"`
	Description string         `gorm:"description" json:"description"`
}

type HotelAddress struct {
	gorm.Model
	HotelId  uuid.UUID `gorm:"hotel_id" json:"hotel_id"`
	Address1 string    `gorm:"address_1" json:"address_1"`
	Address2 string    `gorm:"address_2" json:"address_2"`
	City     string    `gorm:"city" json:"city"`
	State    string    `gorm:"state" json:"state"`
	Country  string    `gorm:"country" json:"country"`
	Zipcode  string    `gorm:"zipcode" json:"zipcode"`
}
