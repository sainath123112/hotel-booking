package handler

import (
	"encoding/json"
	"net/http"

	"github.com/sainath/hotel_management/hotel-service/model"
	"github.com/sainath/hotel_management/hotel-service/service"
)

func SampleHandler(w http.ResponseWriter, r *http.Request) {
	var hotel model.Hotel
	json.NewDecoder(r.Body).Decode(&hotel)
	w.Header().Add("Content-Type", "application/json")
	//w.WriteHeader(http.StatusBadGateway)
	json.NewEncoder(w).Encode(service.AddHotel(hotel))
}
