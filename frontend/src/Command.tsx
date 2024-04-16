import React, { useState } from 'react';
import CreateBooking from "./CreateBooking";
import CancelBooking from "./CancelBooking";
import CreateCustomer from "./CreateCustomer";
import CreateRoom from "./CreateRoom";

export default function Command() {
    const [returnValue, setReturnValue] = useState("");

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
            <CreateBooking postMappings={postMappings}/>
            <CancelBooking postMappings={postMappings}/>
            <CreateCustomer postMappings={postMappings}/>
            <CreateRoom postMappings={postMappings}/>


            <pre>{returnValue}</pre>
            <hr/>
        </div>
    );
}
