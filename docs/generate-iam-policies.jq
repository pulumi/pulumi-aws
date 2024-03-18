.Policies
  | sort_by(.PolicyName)
  | map(
    select(.Arn | startswith("arn:aws:iam::aws:policy"))
    | {Name:.PolicyName, Value:.Arn}
    | "		{Name: \"\(.Name | gsub("-"; ""))\", Value: \"\(.Value)\"},"
  )
  | join("\n")
