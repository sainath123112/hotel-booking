package repository

import (
	"gorm.io/driver/postgres"
	"gorm.io/gorm"
)

func ConnectDb() (*gorm.DB, error) {
	dsn := "host=localhost user=sainath password=Sainath1231 dbname=hotel_service port=5432 sslmode=disable"

	db, err := gorm.Open(postgres.Open(dsn), &gorm.Config{})
	

	return db, err
}
