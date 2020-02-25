import * as React from "react";
import { Attachments } from "../model/TestRunModel";
import MaterialTable from "material-table";

interface AttachmentsListProps {
  attachments: Attachments;
}

const AttachmentsList = ({ attachments }: AttachmentsListProps) => {
  return (
    <div data-testid="attachments-list">
      <MaterialTable
        title=""
        style={{ boxShadow: "none" }}
        options={{
          sorting: true,
          paging: false
        }}
        columns={[{ title: "File name", field: "fileName" }]}
        data={attachments.attachments.map(attachment => ({
          fileName: attachment.fileName
        }))}
      />
    </div>
  );
};

export default AttachmentsList;