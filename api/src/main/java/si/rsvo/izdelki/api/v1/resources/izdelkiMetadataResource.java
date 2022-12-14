package si.rsvo.izdelki.api.v1.resources;

import com.kumuluz.ee.logs.cdi.Log;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.rsvo.izdelki.api.v1.dtos.UploadImageResponse;
import si.rsvo.izdelki.lib.izdelkiMetadata;
import si.rsvo.izdelki.services.beans.izdelkiMetadataBean;
import si.rsvo.izdelki.services.clients.AmazonRekognitionClient;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Log
@ApplicationScoped
@Path("/izdelki")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class izdelkiMetadataResource {

    private Logger log = Logger.getLogger(izdelkiMetadataResource.class.getName());

    @Inject
    private izdelkiMetadataBean izdelkiMetadataBean;

    @Operation(description = "Get all izdelki.", summary = "Get all metadata")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "List of izdelki",
                    content = @Content(schema = @Schema(implementation = izdelkiMetadata.class, type = SchemaType.ARRAY)),
                    headers = {@Header(name = "X-Total-Count", description = "Number of objects in list")}
            )})
    @GET
    public Response getizdelkiMetadata() {

        List<izdelkiMetadata> izdelki = izdelkiMetadataBean.getizdelkiMetadata();

        return Response.status(Response.Status.OK).entity(izdelki).build();
    }

    @Operation(description = "Get izdelek by id", summary = "Get izdelek by id")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "List of izdelki",
                    content = @Content(schema = @Schema(implementation = izdelkiMetadata.class)),
                    headers = {@Header(name = "X-Total-Count", description = "Number of objects in list")}
            )})
    @GET
    @Path("/{id}")
    public Response getIzdelekById(@Parameter(description = "Izdelek ID.", required = true)
                                     @PathParam("id") Integer id) {

        izdelkiMetadata izdelek = izdelkiMetadataBean.getIzdelekById(id);

        return Response.status(Response.Status.OK).entity(izdelek).build();
    }

    @GET
    @Path("/byNaziv/{naziv}")
    public Response getNazivByNaziv(@Parameter(description = "Get naziv by naziv.", required = true)
                                           @PathParam("naziv") String naziv) {

        List<izdelkiMetadata> izdelki = izdelkiMetadataBean.getNazivByNaziv(naziv);

        return Response.status(Response.Status.OK).entity(izdelki).build();
    }

    @GET
    @Path("/byTrgovina/{trgovina}")
    public Response getTrgovinaByTrgovina(@Parameter(description = "Get trgovina by trgovina.", required = true)
                                    @PathParam("trgovina") String trgovina) {

        List<izdelkiMetadata> izdelki = izdelkiMetadataBean.getTrgovinaByTrgovina(trgovina);

        return Response.status(Response.Status.OK).entity(izdelki).build();
    }

    @GET
    @Path("/byTip/{tip}")
    public Response getTipByTip(@Parameter(description = "Get tip by tip.", required = true)
                                          @PathParam("tip") String tip) {

        List<izdelkiMetadata> izdelki = izdelkiMetadataBean.getTipByTip(tip);

        return Response.status(Response.Status.OK).entity(izdelki).build();
    }

    @Operation(description = "Add izdelek metadata.", summary = "Add izdelek")
    @APIResponses({
            @APIResponse(responseCode = "201",
                    description = "Metadata successfully added."
            ),
            @APIResponse(responseCode = "405", description = "Validation error .")
    })
    @POST
    public Response createIzdelkiMetadata(@RequestBody(
            description = "DTO object with izdelki metadata.",
            required = true, content = @Content(
            schema = @Schema(implementation = izdelkiMetadata.class))) izdelkiMetadata izdelkiMetadata) {

        if ((izdelkiMetadata.getId() == null)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else {
            izdelkiMetadata = izdelkiMetadataBean.createIzdelkiMetadata(izdelkiMetadata);
        }

        return Response.status(Response.Status.CONFLICT).entity(izdelkiMetadata).build();

    }

    @Operation(description = "Delete metadata for izdelek.", summary = "Delete metadata")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "Metadata successfully deleted."
            ),
            @APIResponse(
                    responseCode = "404",
                    description = "Not found."
            )
    })
    @DELETE
    @Path("/delete/{izdelekId}")
    public Response deleteIzdelkiMetadata(@Parameter(description = "Metadata ID.", required = true)
                                        @PathParam("izdelekId") Integer izdelekId){

        boolean deleted = izdelkiMetadataBean.deleteIzdelkiMetadata(izdelekId);

        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
