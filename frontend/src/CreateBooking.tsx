import React, { useState } from 'react';

export default function CreateBooking({ postMappings }) {
    const [customerID, setCustomerID] = useState("");
    const [roomID, setRoomID] = useState("");
    const [startDate, setStartDate] = useState("");
    const [endDate, setEndDate] = useState("");

    const handleCustomerIDChange = (e) => {
        setCustomerID(e.target.value);
    };

    const handleRoomIDChange = (e) => {
        setRoomID(e.target.value);
    };

    const handleStartDateChange = (e) => {
        setStartDate(e.target.value);
    };

    const handleEndDateChange = (e) => {
        setEndDate(e.target.value);
    };

    const handleSubmit = () => {
        if (!customerID || !roomID || !startDate || !endDate) {
            alert("Please enter all required information.");
            return;
        }
        const requestBody = {
            customerID,
            roomID,
            startDate,
            endDate
        };
        postMappings('http://localhost:8081/createBooking', requestBody);
    };

    return (
        <div>
            <h2>Create Booking</h2>
            <div>
                <label htmlFor="customerID">Customer ID:</label>
                <input
                    type="number"
                    id="customerID"
                    value={customerID}
                    onChange={handleCustomerIDChange}
                    required
                />
            </div>
            <div>
                <label htmlFor="roomID">Room ID:</label>
                <input
                    type="number"
                    id="roomID"
                    value={roomID}
                    onChange={handleRoomIDChange}
                    required
                />
            </div>
            <div>
                <label htmlFor="startDate">Start Date:</label>
                <input
                    type="date"
                    id="startDate"
                    value={startDate}
                    onChange={handleStartDateChange}
                    required
                />
            </div>
            <div>
                <label htmlFor="endDate">End Date:</label>
                <input
                    type="date"
                    id="endDate"
                    value={endDate}
                    onChange={handleEndDateChange}
                    required
                />
            </div>
            <button className="submit-button" onClick={handleSubmit}>Create Booking</button>
        </div>
    );
}
