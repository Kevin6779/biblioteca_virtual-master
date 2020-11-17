import React from "react";
import { Card, Button } from "react-bootstrap";
import Book from '../img/book.png'
function CardLibro(props) {
    const {nombre}=props;
  return (
    <Card className="text-center">
      <Card.Img variant="top" src={Book} />
      <Card.Body>
        <Card.Title>{nombre}</Card.Title>
        <Card.Text>
          With supporting text below as a natural lead-in to additional content.
        </Card.Text>
      </Card.Body>
      <Card.Footer className="text-muted">
      <Button variant="info">Actualizar</Button>
      <Button variant="danger">Eliminar</Button>
      </Card.Footer>
    </Card>
  );
}
export default CardLibro;