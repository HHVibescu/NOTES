#!/bin/bash
PSQL=$(psql --username=freecodecamp --dbname=salon -t -c)
echo "~~~~~ MY SALON ~~~~~

Welcome to My Salon, how can I help you?
"

display_services() {
   psql --username=freecodecamp --dbname=salon -t -c "SELECT service_id, name FROM services;" | while IFS=" | " read -r service_id name; do
    if [[ -n $name ]];
    then
    echo "$service_id) $name"
    fi
  done
}

while true
do
  display_services
  read SERVICE_ID_SELECTED
  result=$(psql --username=freecodecamp --dbname=salon -t -c "SELECT * FROM services WHERE service_id = $SERVICE_ID_SELECTED;")
  if [[ -z $result ]]
  then
  echo "I could not find that service. What would you like today?"
  else
  # ask for phone
  echo "What's your phone number?"
  read CUSTOMER_PHONE
  numresult=$(psql --username=freecodecamp --dbname=salon -t -c "SELECT * FROM customers WHERE phone = '$CUSTOMER_PHONE';")
  if [[ -z $numresult ]]
  then
  echo "I don't have a record for that phone number, what's your name?"
  read CUSTOMER_NAME
  psql --username=freecodecamp --dbname=salon -t -c "INSERT INTO customers(name, phone) VALUES('$CUSTOMER_NAME', '$CUSTOMER_PHONE')"
  fi
  echo "What time would you like your cut, $CUSTOMER_NAME?"
  read SERVICE_TIME
  psql --username=freecodecamp --dbname=salon -t -c "INSERT INTO appointments(customer_id, service_id, time) VALUES(
      (SELECT customer_id FROM customers WHERE phone = '$CUSTOMER_PHONE'),
      $SERVICE_ID_SELECTED,
      '$SERVICE_TIME');"
  choresult=$(psql --username=freecodecamp --dbname=salon -t -c "SELECT name FROM services WHERE service_id = '$SERVICE_ID_SELECTED';")
  echo "I have put you down for a $choresult at $SERVICE_TIME, $CUSTOMER_NAME".
  break
  fi
done
