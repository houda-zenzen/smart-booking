import React, { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

function App() {

  const [services, setServices] = useState([]);

  // Charger les services
  const loadServices = async () => {
    try {
      const response = await axios.get("http://localhost:8080/services");
      setServices(response.data);
    } catch (error) {
      console.error("Error loading services:", error);
    }
  };

  // Charger les données au démarrage
  useEffect(() => {
    loadServices();
  }, []);

  // Supprimer un service
  const deleteService = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/services/${id}`);
      loadServices();
    } catch (error) {
      console.error("Error deleting service:", error);
    }
  };

  return (
    <div className="App">

      <h1>Smart Booking Services</h1>

      {services.length === 0 ? (
        <p>No services found</p>
      ) : (
        services.map((service) => (
          <div
            key={service.id}
            style={{
              border: "1px solid #ccc",
              padding: "15px",
              margin: "15px",
              borderRadius: "10px"
            }}
          >
            <h2>{service.name}</h2>

            <p>{service.description}</p>

            <h3>{service.price} $</h3>

            <button onClick={() => deleteService(service.id)}>
              Delete
            </button>
          </div>
        ))
      )}

    </div>
  );
}

export default App;