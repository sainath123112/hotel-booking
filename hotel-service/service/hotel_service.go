package service

import (
	"log"

	"github.com/google/uuid"
	"github.com/sainath/hotel_management/hotel-service/model"
	"github.com/sainath/hotel_management/hotel-service/repository"
	"gorm.io/gorm"
)

var (
	db  *gorm.DB
	err error
)

func init() {
	db, err = repository.ConnectDb()
	if err != nil {
		log.Println("Unable to connect database due to: " + err.Error())
	}
	//db.AutoMigrate(model.Hotel{}, model.HotelAddress{})

}

func AddHotel(hotel model.Hotel) model.Hotel {
	hotel.Id = uuid.New()
	db.Create(&hotel)
	return hotel
}
