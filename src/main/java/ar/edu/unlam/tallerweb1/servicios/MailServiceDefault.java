package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class MailServiceDefault implements MailService{
    @Override
    public void enviarResetClave(String usuario) {

    }

    @Override
    public void enviarMailActivarCuenta(String mail) {

    }
}
