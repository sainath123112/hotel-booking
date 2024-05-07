package main

import (
	"log"
	"net/http"

	"github.com/gorilla/mux"
	"github.com/sainath/hotel_management/hotel-service/handler"
)

func main() {
	r := mux.NewRouter()
	r.HandleFunc("/sample", handler.SampleHandler).Methods("GET")
	log.Println("Listening on port: 8081")
	http.ListenAndServe(":8081", r)
}
