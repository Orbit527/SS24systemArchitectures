import React, { useState } from 'react';

export default function CancelBooking({ postMappings }) {
    const [bookingID, setBookingID] = useState("");

    const handleBookingIDChange = (e) => {
        setBookingID(e.target.value);
    };

    const handleSubmit = () => {
        if (!bookingID) {
            alert("Please enter the booking ID.");
            return;
        }
        const requestBody = {
            id: bookingID
        };
        postMappings('http://localhost:8081/cancelBooking', requestBody);
    };

    return (
        <div>
            <div>
                <label htmlFor="bookingID">Booking ID:</label>
                <input
                    type="number"
                    id="bookingID"
                    value={bookingID}
                    onChange={handleBookingIDChange}
                    required
                />
            </div>
            <button onClick={handleSubmit}>Cancel Booking</button>
        </div>
    );
}
