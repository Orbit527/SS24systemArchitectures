import React, { useState } from 'react';
import GetBookings from "./GetBookings";
import GetCustomers from "./GetCustomers";
import GetFreeRooms from "./GetFreeRooms";

export default function Query() {
    const [returnValue, setReturnValue] = useState("");

    const getMappings = (url: string) => {
        fetch(url)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text();
            })
            .then(returnValue => {
                setReturnValueFormatted(returnValue);
            });
    };

    const postMappings = (url, requestBody) => {
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text();
            })
            .then(returnValue => {
                setReturnValueFormatted(returnValue);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    };

    const setReturnValueFormatted = (returnValue) => {
        // Add line breaks after every {
        returnValue = returnValue.replace(/{/g, '{\n');
        setReturnValue(returnValue);
    };

    return (
        <div>
            <button onClick={() => getMappings('http://localhost:8082/readOutAllEvents')}>Read Out All Events</button>
            <button onClick={() => getMappings('http://localhost:8082/restoreDatabase')}>Restore Database</button>
            <button onClick={() => getMappings('http://localhost:8082/clearDatabase')}>Clear Database</button>

            <GetBookings postMappings={postMappings}/>
            <GetCustomers postMappings={postMappings}/>
            <GetFreeRooms postMappings={postMappings}/>

            <pre>{returnValue}</pre>
        </div>
    );
}
