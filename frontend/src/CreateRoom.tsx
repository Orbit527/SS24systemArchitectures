import React, { useState } from 'react';

export default function CreateRoom({ postMappings }) {
    const [roomNr, setRoomNr] = useState("");
    const [floor, setFloor] = useState("");
    const [capacity, setCapacity] = useState("");

    const handleRoomNrChange = (e) => {
        setRoomNr(e.target.value);
    };

    const handleFloorChange = (e) => {
        setFloor(e.target.value);
    };

    const handleCapacityChange = (e) => {
        setCapacity(e.target.value);
    };

    const handleSubmit = () => {
        if (!roomNr || !floor || !capacity) {
            alert("Please enter all required information.");
            return;
        }

        // Prepare the request body
        const requestBody = {
            roomNr,
            floor,
            capacity
        };

        // Send the POST request
        postMappings('http://localhost:8081/createRoom', requestBody);
    };

    return (
        <div>
            <h2>Create Room</h2>
            <div>
                <label htmlFor="roomNr">Room Number:</label>
                <input
                    type="number"
                    id="roomNr"
                    value={roomNr}
                    onChange={handleRoomNrChange}
                    required
                />
            </div>
            <div>
                <label htmlFor="floor">Floor:</label>
                <input
                    type="number"
                    id="floor"
                    value={floor}
                    onChange={handleFloorChange}
                    required
                />
            </div>
            <div>
                <label htmlFor="capacity">Capacity:</label>
                <input
                    type="number"
                    id="capacity"
                    value={capacity}
                    onChange={handleCapacityChange}
                    required
                />
            </div>
            <button className="submit-button" onClick={handleSubmit}>Create Room</button>
        </div>
    );
}
