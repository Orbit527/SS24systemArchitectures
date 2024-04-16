import React, { useState } from 'react';

export default function GetBookings({postMappings}) {
    const [startDate, setStartDate] = useState("");
    const [endDate, setEndDate] = useState("");

    const handleStartDateChange = (e) => {
        setStartDate(e.target.value);
    };

    const handleEndDateChange = (e) => {
        setEndDate(e.target.value);
    };

    const handleSubmit = () => {
        if (!startDate || !endDate) {
            alert("Please enter both start date and end date.");
            return;
        }
        postMappings('http://localhost:8082/getBookings', { startDate, endDate });
    };

    return (
        <div>
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
            <button onClick={handleSubmit}>Get Bookings</button>
        </div>
    );
}
