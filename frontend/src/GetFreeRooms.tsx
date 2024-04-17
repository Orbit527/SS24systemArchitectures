import React, { useState } from 'react';

export default function GetFreeRooms({ postMappings }) {
    const [startDate, setStartDate] = useState("");
    const [endDate, setEndDate] = useState("");
    const [personCount, setPersonCount] = useState("");

    const handleStartDateChange = (e) => {
        setStartDate(e.target.value);
    };

    const handleEndDateChange = (e) => {
        setEndDate(e.target.value);
    };

    const handlePersonCountChange = (e) => {
        setPersonCount(e.target.value);
    };

    const handleSubmit = () => {
        if (!startDate || !endDate || !personCount) {
            alert("Please enter start date, end date, and person count.");
            return;
        }
        postMappings('http://localhost:8082/getFreeRooms', { startDate, endDate, personCount });
    };

    return (
        <div>
            <h2>Get Free Rooms</h2>
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
            <div>
                <label htmlFor="personCount">Person Count:</label>
                <input
                    type="number"
                    id="personCount"
                    value={personCount}
                    onChange={handlePersonCountChange}
                    required
                />
            </div>
            <button className="submit-button" onClick={handleSubmit}>Get Free Rooms</button>
        </div>
    );
}
