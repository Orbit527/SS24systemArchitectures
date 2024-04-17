import React from 'react';

export default function QueryDatabase({ getMappings }) {

    return (
        <div>
            <h2>Database</h2>
            <button className="submit-button" onClick={() => getMappings('http://localhost:8082/readOutAllEvents')}>Read Out All Events</button>
            <button className="submit-button" onClick={() => getMappings('http://localhost:8082/restoreDatabase')}>Restore Database</button>
            <button className="submit-button" onClick={() => getMappings('http://localhost:8082/clearDatabase')}>Clear Database</button>

        </div>
    );
}
