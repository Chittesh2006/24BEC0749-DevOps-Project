document.addEventListener("DOMContentLoaded", () => {
    const contactForm = document.querySelector(".contact-form");
    
    if (contactForm) {
        contactForm.addEventListener("submit", async (e) => {
            e.preventDefault();

            const payload = {
                clientName: document.getElementById("name").value,
                clientEmail: document.getElementById("email").value,
                projectType: document.getElementById("project-type").value,
                messageDescription: document.getElementById("message").value
            };

            try {
                const response = await fetch("http://localhost:8081/api/tasks/submit", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(payload)
                });

                if (response.ok) {
                    alert("Awesome! Your design request has reached our Spring Boot backend successfully.");
                    contactForm.reset();
                } else {
                    alert("Backend rejected processing. Verify endpoint constraints.");
                }
            } catch (error) {
                console.error("Connection Error:", error);
                alert("Error connecting to the Spring Boot application pipeline!");
            }
        });
    }
});