package com.demo.loanApplicationSystem.service.rest;
import com.demo.loanApplicationSystem.dto.LoanApplicationUserDto;
import com.demo.loanApplicationSystem.service.api.LoanApplicationSystemService;
import com.demo.loanApplicationSystem.service.impl.LoanApplicationSystemServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class LoanApplicationSystemRestService {

    private LoanApplicationSystemServiceImpl applicationSystemService;

    @POST
    @Path("info")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getInfo(LoanApplicationUserDto loanApplicationUserDto) throws JsonProcessingException {
        String userName = loanApplicationUserDto.getUserName();
        if (userName == null)
            return Response.noContent().entity("İsim boş olamaz!").build();

        String identityNumber = loanApplicationUserDto.getIdentityNumber();
        if (identityNumber == null)
            return Response.noContent().entity("Kimlik No boş olamaz!").build();

        String phoneNumber = loanApplicationUserDto.getPhoneNumber();
        if (phoneNumber == null)
            return Response.noContent().entity("Telefon  boş olamaz!").build();

        Double monthlyIncome = loanApplicationUserDto.getMonthlyIncome();
        if (monthlyIncome == null)
            return Response.noContent().entity("Aylık gelir  boş olamaz!").build();

        Boolean scoreResult = applicationSystemService.calculateLoanScore(loanApplicationUserDto);
        loanApplicationUserDto.setResult(scoreResult);

        return Response.ok().build();
    }
}
