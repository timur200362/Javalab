package main

import (
	"context"
	"job-service/internal/application"
	"log"
	"os"
	"os/signal"
	"syscall"
)

func main() {
	ctx, cancel := signal.NotifyContext(context.Background(), syscall.SIGTERM, os.Interrupt)
	defer cancel()

	if err := application.Run(ctx); err != nil {
		log.Fatal(err)
	}

}
