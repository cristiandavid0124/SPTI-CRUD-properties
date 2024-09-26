$(document).ready(function() {
    const propertyForm = $('#propertyForm');
    const propertyList = $('#propertyList');

    // Function to fetch and display properties
    function fetchProperties() {
        $.ajax({
            url: '/properties',
            method: 'GET',
            success: function(properties) {
                propertyList.empty(); // Clear the property list
                properties.forEach(function(property) {
                    const propertyItem = `
                        <div class="card my-3">
                            <div class="card-body">
                                <h5 class="card-title">${property.address}</h5>
                                <p class="card-text">Price: $${property.price} | Size: ${property.size} sq ft</p>
                                <p>${property.description}</p>
                                <button class="btn btn-info" onclick="editProperty(${property.id})">Edit</button>
                                <button class="btn btn-danger" onclick="deleteProperty(${property.id})">Delete</button>
                            </div>
                        </div>`;
                    propertyList.append(propertyItem);
                });
            },
            error: function(err) {
                console.error('Error fetching properties:', err);
            }
        });
    }

    // Function to add a property
    propertyForm.on('submit', function(e) {
        e.preventDefault();

        const property = {
            address: $('#address').val(),
            price: $('#price').val(),
            size: $('#size').val(),
            description: $('#description').val(),
        };

        $.ajax({
            url: '/properties',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(property),
            success: function() {
                propertyForm[0].reset(); // Reset the form
                fetchProperties(); // Refresh the property list
            },
            error: function(err) {
                console.error('Error adding property:', err);
            }
        });
    });

    // Function to delete a property
    window.deleteProperty = function(id) {
        $.ajax({
            url: `/properties/${id}`,
            method: 'DELETE',
            success: function() {
                fetchProperties(); // Refresh the property list
            },
            error: function(err) {
                console.error('Error deleting property:', err);
            }
        });
    };

    // Function to edit a property
    window.editProperty = function(id) {
        $.ajax({
            url: `/properties/${id}`,
            method: 'GET',
            success: function(property) {
                $('#address').val(property.address);
                $('#price').val(property.price);
                $('#size').val(property.size);
                $('#description').val(property.description);

                propertyForm.off('submit').on('submit', function(e) {
                    e.preventDefault();
                    const updatedProperty = {
                        address: $('#address').val(),
                        price: $('#price').val(),
                        size: $('#size').val(),
                        description: $('#description').val(),
                    };

                    $.ajax({
                        url: `/properties/${id}`,
                        method: 'PUT',
                        contentType: 'application/json',
                        data: JSON.stringify(updatedProperty),
                        success: function() {
                            propertyForm[0].reset(); // Reset the form
                            fetchProperties(); // Refresh the property list
                            // Re-bind the original form submit handler
                            propertyForm.off('submit').on('submit', arguments.callee);
                        },
                        error: function(err) {
                            console.error('Error updating property:', err);
                        }
                    });
                });
            },
            error: function(err) {
                console.error('Error fetching property for edit:', err);
            }
        });
    };

    // Fetch properties on initial load
    fetchProperties();
});
