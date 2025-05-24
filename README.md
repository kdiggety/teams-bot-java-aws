# Microsoft Teams Troubleshooting Bot

This is a self-service chatbot for Microsoft Teams built with Java (Spring Boot) and AWS services. It helps service consumers troubleshoot functional and performance issues.

## Features
- Natural language processing for latency and error queries
- CloudWatch metrics and logs integration
- Log summarization using Amazon Bedrock (Claude)
- Message delivery via Teams API

## Prerequisites
- Java 17+
- AWS credentials configured
- Microsoft Teams bot registration with OAuth token

## Setup

### 1. Build and Run
```bash
./mvnw spring-boot:run
```

### 2. Docker
```bash
docker-compose up --build
```

## Endpoints
- `POST /api/messages`: Receives messages from Teams

## Environment Variables
Set the following variables:
- `AWS_ACCESS_KEY_ID`
- `AWS_SECRET_ACCESS_KEY`
- `AWS_REGION`
- `TEAMS_BOT_TOKEN`

## Sample Curl
```
curl -X POST http://localhost:8080/api/messages \
  -H "Content-Type: application/json" \
  -d '{
    "user": "user@example.com",
    "message": "Why is the login microservice slow?"
  }'
```
## License
MIT
