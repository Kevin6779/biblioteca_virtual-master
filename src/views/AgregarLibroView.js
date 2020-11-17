import React, { useState, useEffect } from "react";
import { Button, Container } from "react-bootstrap";
import CreateLibroModal from '../components/CreateLibroModal';

function AgregarLibroView() {
    const [show, setShow] = useState(false);

    const handleClose = () => {
        setShow(false)
    }

    const handleOpenModal = () => {
        setShow(true)
    }

    return (
        <Container>
            <Button onClick={handleOpenModal} variant="primary">Agregar Libro</Button>
            {
                show &&
                <CreateLibroModal
                    show={show}
                    handleClose={handleClose} />
            }
        </Container>
    );
}

export default AgregarLibroView;